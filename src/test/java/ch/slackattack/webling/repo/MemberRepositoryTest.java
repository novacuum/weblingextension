package ch.slackattack.webling.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MemberRepositoryTest {

  @Mock
  private MemberRepository memberRepository;

  @Test
  public void findById_whenMemberExists_returnsMember() {
    // Arrange
    Member expectedMember = new Member();
    expectedMember.setId(1);
    when(memberRepository.findById(1)).thenReturn(Optional.of(expectedMember));

    // Act
    Optional<Member> actual = memberRepository.findById(1);

    // Assert
    assertTrue(actual.isPresent());
    assertEquals(expectedMember, actual.get());
  }

  @Test
  public void findById_whenMemberDoesNotExist_returnsEmptyOptional() {
    // Arrange
    when(memberRepository.findById(1)).thenReturn(Optional.empty());

    // Act
    Optional<Member> actual = memberRepository.findById(1);

    // Assert
    assertFalse(actual.isPresent());
  }
}
